package com.sekerbank.bankingapp.Dto;

import com.sekerbank.bankingapp.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mappings({
            @Mapping(source = "accountId", target = "account.id"),
            @Mapping(source = "toAccountNumber", target = "to_account.accountNumber")
    })
    Transaction toEntity(TransactionRequest transactionRequest);

    @Mappings({
            @Mapping(source = "account.id", target = "accountId"),
            @Mapping(source = "to_account.accountNumber", target = "toAccountNumber")
    })
    TransactionRequest toDto(Transaction transaction);
}
