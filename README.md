# kinggen-java
A simple Java wrapper (or, rather the Java implementation of https://github.com/KingAlts/KingGenCSharp) for the KingGen API.

# Dependencies
This project requires Java 8+.
The only dependency is GSON (2.2.4 and higher)

# Usage
First, you need to [obtain a KingGen API key.](#getting-an-api-key)

To start, you have to create a KingGen object and provide the api key obtained earlier.
With that object you can fetch the user information and generate accounts 
Some examples:
```java
public static void main(String[] args) {
  KingGen kingGen = new KingGen("your-api-key");

  //If you (for some unknown reason) want to fetch the user profile every time an account is generated, you can do this:
  kingGen.alwaysFetch(); //method chaining is supported
  //this will make the wrapper always fetch user info before generating an account.
  
  //Generating an account
  Account account = kingGen.generateAccount(); //will throw an OutOfStock exception if there's no stock
  account.getEmail(); //getting the credentials
  account.getPassword();

  //to check for stock you can do this:
  kingGen.fetchStock().getStock().getAmount();

  //to get the user profile:
  kingGen.fetchUserProfile().getUserProfile();

  //or just this (if you've fetched the user profile before and don't need to update any info)
  kingGen.getUserProfile();
}
```
  
# Handling errors
  There are three types of exceptions that can be thrown, all of which are located in `me.angles.kinggen.exceptions`:
  
    > KingGenException, thrown when the API has returned an error that's not covered by the other exceptions described below. 
                        (for example: this is exception thrown when you try to generate an alt but you've reached the daily limit.)
                        another example is when the request to the API has failed and an IOException was thrown. 
    Then KingGenException will have a cause that is the IOException.   
    
    > OutOfStockException, thrown when you attempt to generate an account, but there is no stock.

    > InvalidAPIKeyException, thrown when you pass an invalid API key to the KingGen object and attempt to make a request to the API.

# Getting an API key
To get an API key, simply navigate to https://kinggen.wtf/ and click Login in the top-right and authenticate with Discord. 
You'll find your API key on the dashboard (https://kinggen.wtf/dashboard)



