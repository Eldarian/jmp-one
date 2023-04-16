module com.eldarian.jmp.app {
    requires com.eldarian.jmp.dto;
    requires com.eldarian.jmp.bank.api;
    requires jmp.cloud.service.impl;
    uses com.eldarian.jmp.service.api.Service;
    uses com.eldarian.jmp.bank.api.Bank;

}