package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("https://api.github.com/users/{username}/repos")
    Call<List<Pojo>> getRepos(@Path("username") String username);
}