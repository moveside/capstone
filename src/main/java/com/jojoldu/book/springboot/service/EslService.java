package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.Repository.EslRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EslService {
    private final EslRepository eslRepository;


}
