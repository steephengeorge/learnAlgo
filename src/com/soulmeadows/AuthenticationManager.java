package com.soulmeadows;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.time.Duration;
import java.time.Instant;


public class AuthenticationManager {
    private Map<String, Integer> map;
    private int timeToLive;
    public AuthenticationManager(int timeToLive) {
        this.map = new LinkedHashMap<String, Integer>();
//        {
//             @Override
//             protected boolean removeEldestEntry(java.util.Map.Entry<String, Long> eldest) {
//
//                 return eldest.getValue() > System.currentTimeMillis()/ 1000;
//             }
//         };
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
       //var expiry = Instant.ofEpochSecond(currentTime).toEpochMilli();
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        var expiry = map.getOrDefault(tokenId, 0);
        if(expiry == 0){
            return;
        }
        if(expiry > currentTime){
            generate(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
//        var expiry = Instant.ofEpochSecond(currentTime).toEpochMilli();
        int counter = 0;
        for(var val: map.values()){
            if(val < currentTime){
                ++counter;
            }
        }
        return counter;
    }

    public static  void main(String[] args){
        AuthenticationManager authenticationManager = new AuthenticationManager(5); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
        authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
        authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
        var count = authenticationManager.countUnexpiredTokens(6); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
        authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
        authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
        authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
        var recentCount = authenticationManager.countUnexpiredTokens(15); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
    }

}
