Sample Automation Tests
====================

Libraries used:
1. Cucumber 4
2. Serenity
3. Rest Assured 

mvn commands to run the test
#### ATO Tax calculator scenario - 
    mvn  post-integration-test -Dcucumber.filter.tags=@taxCalculator 

#### MLC Life View scenario - 
    mvn post-integration-test -Dcucumber.filter.tags=@Lifeview 

#### AU Post API Tests - 
    mvn post-integration-test -Dcucumber.filter.tags=@AUPost 

#### All Tests - 
    mvn post-integration-test -Dcucumber.filter.tags=@AllTests 

After execution serenity test report will be available to view in 
\target\site\serenity\index.html
