module jmp.cloud.service.impl {
    exports com.eldarian.jmp.cloud.service.impl;
    requires transitive com.eldarian.jmp.service.api;
    provides com.eldarian.jmp.service.api.Service with com.eldarian.jmp.cloud.service.impl.CloudService;
}