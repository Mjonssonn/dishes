package com.dishes.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.dishes.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Dish save(Dish dish) {
        dynamoDBMapper.save(dish);
        return dish;
    }

    public List<Dish> findAllDishes() {
        return dynamoDBMapper.scan(Dish.class, new DynamoDBScanExpression());
    }

    public Dish getDishById(String dishId) {
        return dynamoDBMapper.load(Dish.class, dishId);
    }

    public String delete(String dishId) {
        Dish dish = dynamoDBMapper.load(Dish.class, dishId);
        dynamoDBMapper.delete(dish);
        return dishId;
    }

}
