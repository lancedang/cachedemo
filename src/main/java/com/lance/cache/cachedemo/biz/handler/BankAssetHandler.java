package com.lance.cache.cachedemo.biz.handler;

import com.lance.cache.cachedemo.common.api.Response;
import com.lance.cache.cachedemo.factory.ResponseHandlerInterface;
import org.springframework.stereotype.Component;

@Component(value = "bankAssetHandler")
public class BankAssetHandler implements ResponseHandlerInterface {
    @Override
    public Response handle() {
        return null;
    }
}
