package me.angles.kinggen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.angles.kinggen.data.Account;
import me.angles.kinggen.data.Stock;
import me.angles.kinggen.data.UserProfile;
import me.angles.kinggen.exceptions.InvalidApiKeyException;
import me.angles.kinggen.exceptions.OutOfStockException;
import me.angles.kinggen.requests.Endpoint;
import me.angles.kinggen.requests.RequestUtil;

public class KingGen {
    public static final String BASE_ROUTE = "https://kinggen.wtf/api/v2/%s?key=%s";        //vv exclude fields without SerializedName annotation vv
    public static final Gson gson = new GsonBuilder().addDeserializationExclusionStrategy(new FieldExclusionStrategy()).create();

    private final String apiKey;
    private UserProfile userProfile;
    private Stock stock;

    private boolean alwaysFetch; //whether it should always fetch the user profile upon generating an account

    public KingGen(String apiKey) {
        if(apiKey == null || apiKey.trim().isEmpty()) throw new InvalidApiKeyException();
        this.apiKey = apiKey;
    }

    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public Stock getStock() {
        return this.stock;
    }

    public KingGen fetchUserProfile() {
        this.userProfile = RequestUtil.fetch(Endpoint.PROFILE, apiKey, UserProfile.class);
        return this;
    }

    public KingGen fetchStock() {
        this.stock = RequestUtil.fetch(Endpoint.PROFILE, apiKey, Stock.class);
        return this;
    }

    public KingGen alwaysFetch() {
        this.alwaysFetch = true;
        return this;
    }

    public Account generateAccount() {
        if(this.alwaysFetch || this.userProfile == null)
            this.fetchUserProfile();

        final Account account = RequestUtil.fetch(Endpoint.ACCOUNT, apiKey, Account.class);
        if(account == null) throw new OutOfStockException();

        this.getUserProfile().accountGenerated(); //increment generated and generatedToday
        return account;
    }
}
