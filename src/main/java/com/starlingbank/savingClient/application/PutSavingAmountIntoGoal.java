package com.starlingbank.savingClient.application;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class PutSavingAmountIntoGoal {

    private String savingAmount;

    private String savingGoalUid;

    private RestTemplate restTemplate;

    private HttpHeaders headers;

    private String transferSavingGoalApiUrl;

    private String transferUid;

    public PutSavingAmountIntoGoal(String savingAmount, String savingGoalUid) {
        this.savingAmount = savingAmount;
        this.savingGoalUid = savingGoalUid;

        this.restTemplate = new RestTemplate();

        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.add("user-agent", "saving-client");
        this.headers.add("Authorization", "Bearer " + "SsbkucXmNaJm5wrppaNFEsj0sZyVtknPPfwyuwg8iLvFKnnjuUaJFA2Eke7pAuAf");

        this.transferUid = UUID.randomUUID().toString();
        this.transferSavingGoalApiUrl = "https://api-sandbox.starlingbank.com/api/v1/savings-goals/" + this.savingGoalUid + "/add-money/" + this.transferUid;
    }

    public void transferSavingGoal() {
        String body = "{\n  \"amount\": {\n\"currency\": \"GBP\",\n\"minorUnits\": " + this.savingAmount + "}\n}";
        HttpEntity<String> request = new HttpEntity<>(body, this.headers);
        restTemplate.exchange(this.transferSavingGoalApiUrl, HttpMethod.PUT, request, JsonNode.class);
    }

}
