package com.example.mygraduationprojectamit.network;



import com.example.mygraduationprojectamit.cart.database.ProductRequest;
import com.example.mygraduationprojectamit.cart.database.ProductUserResponse;
import com.example.mygraduationprojectamit.categories.categoryApis.CategoriesResponse;
import com.example.mygraduationprojectamit.home.products.ProductResponse;
import com.example.mygraduationprojectamit.login.LoginRequest;
import com.example.mygraduationprojectamit.login.LoginResponse;
import com.example.mygraduationprojectamit.productDetails.ProductIdResponse;
import com.example.mygraduationprojectamit.register.RegisterRequest;
import com.example.mygraduationprojectamit.register.RegisterResponse;
import com.example.mygraduationprojectamit.seperatedCategory.CategoryIdResponse;
import com.example.mygraduationprojectamit.seperatedCategory.CategoryIProductdResponse;
import com.example.mygraduationprojectamit.user.UserResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Single;

public interface CategoryApi {
    @GET("api/categories")
    Single<CategoriesResponse> categories();

    @GET("api/products")
    Single<ProductResponse> product();

    @GET("api/categories/{categoryId}")
    Single<CategoryIdResponse> CategorySearchById(@Path("categoryId") int categoryId);

    @GET("api/products/{productId}")
    Single<ProductIdResponse> productById(@Path("productId") int productId);

    @GET("api/user/products")
    Single<ProductUserResponse> Userproduct(@Header("Authorization") String token);

    @PUT("api/user/products/{productId}")
    Single<ProductUserResponse> UserAddproduct(@Body ProductRequest productRequest,
                                           @Path("productId") int productId ,
                                           @Header("Authorization") String token);

    @POST("api/register")
    Single<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("api/login")
    Single<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("api/user")
    Single<UserResponse>user(@Header("Authorization") String Token);


}
