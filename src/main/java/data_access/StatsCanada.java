package data_access;


import okhttp3.*;

import java.io.IOException;


public class StatsCanada {
    public boolean getDataSuccess() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://www.postman.com/postman/workspace/postman-open-technologies-data-and-ai/request/21577788-431f933c-74f0-42bc-9939-b14de7f6171d")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            return response.isSuccessful();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        StatsCanada statsCanada = new StatsCanada();
        System.out.println(statsCanada.getDataSuccess());

    }
}
