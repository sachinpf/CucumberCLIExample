# VMOptions:
# -DfailIfNoTests=false -Dtags="@MyTest" -DnumOfThreads=2
  # -Dfeatures="src/test/resources/features" -Dglue="com.myOrg.Steps"

@MyTest
Feature: Test Parallel Execution
  Scenario: This is my first Scenario
    Given this is my first scenario
    Then just say hi

  Scenario: This is my second Scenario
    Given this is my second scenario
    Then just say bye
