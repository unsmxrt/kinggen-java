# kinggen-java
A Java wrapper for the KingGen API.

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
  kingGen.alwaysFetch() //method chaining is supported
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
  

# Getting an API key
To get an API key, simply navigate to https://kinggen.wtf/ and click Login in the top-right and authenticate with Discord. 
You'll find your API key on the dashboard (https://kinggen.wtf/dashboard)



