package com.book.mvc.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public final class Customer implements Serializable {

    private static final long serialVersionUID = 2L;
    private String customerId;
    private String name;
    private String address;
    private long noOfOrdersMade;
}
