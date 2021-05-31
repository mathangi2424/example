Sample Automation Tests
====================

Libraries used:
1. Cucumber 4
2. Serenity
3. Rest Assured 

mvn commands to run the test
#### ATO Tax calculator scenario - 
    mvn.bat -B verify -Dcucumber.filter.tags=@taxCalculator 

#### MLC Life View scenario - 
    mvn.bat -B verify -Dcucumber.filter.tags=@Lifeview 

#### AU Post API Tests - 
    mvn.bat -B verify -Dcucumber.filter.tags=@AUPost 

#### All Tests - 
    mvn.bat -B verify -Dcucumber.filter.tags=@AllTests 
