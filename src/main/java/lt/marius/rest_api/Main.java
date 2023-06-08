package lt.marius.rest_api;

import retrofit2.Call;

import java.util.List;

import static lt.marius.rest_api.RetrofitBuilder.retrofit;

public class Main {
    public static void main(String[] args) {

        UserService service = retrofit.create(UserService.class);
        Call<User> callSyncUser = service.getUser("eugenp");
        Call<List<User>> callSyncUsers = service.getUsers(10, 2);

//        callSyncUser.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//
//                User user = response.body();
//                System.out.println(user);
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable throwable) {
//                System.out.println(throwable);
//            }
//        });
//
//        callSyncUsers.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                List<User> users = response.body();
//                users.forEach(System.out::println);
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable throwable) {
//                System.out.println(throwable);
//            }
//        });



//        try {
//            Response<User> response = callSync.execute();
//            User user = response.body();
//            System.out.println(user);
//            callSync.cancel();
//
//            System.out.println("========================================");
//
//            Response<List<User>> responseUsers = callSyncList.execute();
//            List<User> users = responseUsers.body();
//            users.forEach(System.out::println);
//            callSyncList.cancel();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
}
