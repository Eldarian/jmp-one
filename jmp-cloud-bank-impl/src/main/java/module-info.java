module com.eldarian.jmp.cloud.bank.impl {
    exports com.eldarian.jmp.cloud.bank.impl;
    requires com.eldarian.jmp.bank.api;
    requires com.eldarian.jmp.dto;
    provides com.eldarian.jmp.bank.api.Bank with com.eldarian.jmp.cloud.bank.impl.CloudBankImpl;
}