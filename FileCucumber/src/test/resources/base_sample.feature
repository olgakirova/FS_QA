#language: en
  Feature: checking file's
    blabla

  @sample
  Scenario Outline: Making file
    Given File name "<Before>"
    When File created
    Then Exists file "<After>" is <Result>
    Examples:
      | Before        | After | Result |
      | /tmp/file_true.txt | /tmp/file_true.txt| 1 |
      | /home/unknown/path/file.txt | /home/unknown/path/file.txt | 0 |



