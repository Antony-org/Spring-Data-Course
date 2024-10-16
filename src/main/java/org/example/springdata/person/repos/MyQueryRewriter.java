package org.example.springdata.person.repos;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.QueryRewriter;

public class MyQueryRewriter implements QueryRewriter {
    @Override
    public String rewrite(String query, Sort sort) {
        return query.replaceAll("Stark", "Waleed");
    }
}
