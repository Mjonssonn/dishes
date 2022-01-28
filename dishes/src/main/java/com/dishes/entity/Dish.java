package com.dishes.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "dishes")
public class Dish {

    @DynamoDBHashKey(attributeName = "dishId")
    @DynamoDBAutoGeneratedKey
    private String dishId;

    @DynamoDBAttribute
    private String dishName;

    @DynamoDBAttribute
    private String calories;

    @DynamoDBAttribute
    private String carbohydrates;

    @DynamoDBAttribute
    private String protein;

    @DynamoDBAttribute
    private String dishImage;

}
