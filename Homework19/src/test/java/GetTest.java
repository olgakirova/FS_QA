import constants.Constants;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

import org.json.*;

import static org.assertj.core.api.Assertions.assertThat;


public class GetTest extends BaseTest{

    @Test
    void baseUrlShouldReturn200(){
        prepareRequest()
                .get()
                .then().statusCode(200);
    }

    @Test
    void getUserShouldReturn200(){
        prepareRequest()
                .get("/users/" + Constants.USERNAME)
                .then().statusCode(200);
    }

    @Test
    void getUserReposShouldReturn200(){
        prepareRequest()
                .get("/users/" + Constants.USERNAME + "/repos")
                .then().statusCode(200);
    }

    @Test
    void testCreateAndCheckIssue() {
        //
        // read file
        //
        String f = getResourceAsString("issue1.json");
        System.out.println(f);

        //
        // create issue
        //
        Response resp = prepareRequest()
                .body(f)
                .header( new Header("Authorization", "token " + Constants.TOKEN) )
                .post("/repos/" + Constants.USERNAME + "/" + Constants.REPO + "/issues");


        resp.then().statusCode(201);
        String s = resp.body().asString();

        //System.out.println("SSSSSSS: " + s);
        JSONObject obj = new JSONObject(s);
        int issue_id_created = obj.getInt("id");

        //System.out.println("IDIDIDID: " + id);
        assertThat(issue_id_created).isGreaterThan(0);


        //
        // list issues
        //
        Response resp2 = prepareRequest()
                //.header( new Header("Authorization", "token " + token) )
                .body(f)
                .get("/repos/" + Constants.USERNAME + "/" + Constants.REPO + "/issues");

        resp2.then().statusCode(200);
        String s2 = resp2.body().asString();

        //System.out.println("SSSSSSS2: " + s2);

        JSONArray json_issues = new JSONArray( s2 );

        boolean found = false;

        // search for our id
        for(int i = 0; i < json_issues.length(); ++i) {
            JSONObject issue = json_issues.getJSONObject(i);
            if (issue.getInt("id") == issue_id_created) {
                found = true;
                break;
            }
        }

        assertThat(found).isEqualTo(true);

        System.out.println("issue_id_created: " + issue_id_created + ", found " + found + ", len " + json_issues.length());
    }

    void editBody(String body_new, int issue_number) {
        //
        // edit body
        //
        String f_new = "{\"body\": \"" + body_new + "\"}";
        Response resp2 = prepareRequest()
                .body(f_new)
                .header( new Header("Authorization", "token " + Constants.TOKEN) )
                .patch("/repos/" + Constants.USERNAME + "/" + Constants.REPO + "/issues/" + issue_number);

        resp2.then().statusCode(200);
    }

    void checkBody(String body_must_be, int issue_number) {
        //
        // GET /repos/:owner/:repo/issues/:issue_number
        //
        Response resp3 = prepareRequest()
                .header( new Header("Authorization", "token " + Constants.TOKEN) )
                .get("/repos/" + Constants.USERNAME + "/" + Constants.REPO + "/issues/" + issue_number);

        resp3.then().statusCode(200);

        String resp3_body = resp3.body().asString();
        JSONObject resp3_json = new JSONObject( resp3_body );
        String body_now = resp3_json.getString("body");


        System.out.println("b_good '" + body_must_be + "'");
        System.out.println("b_now '" + body_now + "'");
        assertThat(body_must_be).isEqualTo(body_now);
    }

    @Test
    void testCreateAndEditBody() {
        //
        // read file
        //
        String f = getResourceAsString("issue2.json");
        JSONObject issue = new JSONObject(f);
        String body = issue.getString("body");
        String body_new = body + " sobaka";


        //
        // create issue
        //
        Response resp1 = prepareRequest()
                .body(f)
                .header( new Header("Authorization", "token " + Constants.TOKEN) )
                .post("/repos/" + Constants.USERNAME + "/" + Constants.REPO + "/issues");

        resp1.then().statusCode(201);

        String s = resp1.body().asString();
        JSONObject obj = new JSONObject(s);
        int issue_number = obj.getInt("number");

        //
        // edit body
        //
        editBody(body_new, issue_number);

        //
        // check body changed
        //
        checkBody(body_new, issue_number);
    }

    @Test
    void testLock() {

        String f = getResourceAsString("issue3.json");
        JSONObject issue = new JSONObject(f);
        String body = issue.getString("body");
        String body_new = body + " zuzuzu";

        //
        // create issue
        //
        Response resp1 = prepareRequest()
                .body(f)
                .header( new Header("Authorization", "token " + Constants.TOKEN) )
                .post("/repos/" + Constants.USERNAME + "/" + Constants.REPO + "/issues");
        resp1.then().statusCode(201);

        String s = resp1.body().asString();
        JSONObject obj = new JSONObject(s);
        int issue_number = obj.getInt("number");

        System.out.println("number " + issue_number);

        //
        // Lock issue
        //

        String reason = "{\"lock_reason\":\"resolved\"}";

        // PUT /repos/:owner/:repo/issues/:issue_number/lock
        Response resp2 = prepareRequest()
                //.body(reason)
                .header( new Header("Authorization", "token " + Constants.TOKEN) )
                .put("/repos/" + Constants.USERNAME + "/" + Constants.REPO + "/issues/" + issue_number + "/lock");
        resp2.then().statusCode(204);


        //
        // edit body
        //
        editBody(body_new, issue_number);

        //
        // check body changed
        // body must NOT be edited
        //
        checkBody(body, issue_number);
    }
}