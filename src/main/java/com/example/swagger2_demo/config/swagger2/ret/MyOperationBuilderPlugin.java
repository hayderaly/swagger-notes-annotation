package com.example.swagger2_demo.config.swagger2.ret;

import com.example.swagger2_demo.config.swagger2.common.SwaggerASMUtil;
import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 3)//一定要大一点   //plugin加载顺序，默认是最后加载
public class MyOperationBuilderPlugin extends ClassLoader implements OperationBuilderPlugin {

    @Autowired
    private TypeResolver typeResolver;

//    @Override
    public void apply(OperationContext operationContext) {
        Map<String, Object> maps = SwaggerRetMapContext.getMap();
        if(maps == null || maps.size() == 0){
            return;
        }
        String requestMappingPatternName = operationContext.requestMappingPattern();

        //if(operationContext.getReturnType().isInstanceOf(Map.class)) {
        if(maps.get(requestMappingPatternName) != null){
            //根据参数上的ApiJsonObject注解中的参数动态生成Class
            Optional<ApiReturnJson> optional = operationContext.findAnnotation(ApiReturnJson.class);
            try {
//                Method method = Swagger2.class.getMethod("restApi");//系统默认取该处的全局变量
//                ApiReturnJson apiReturnJson = method.getAnnotation(ApiReturnJson.class);
//                String name = apiReturnJson.key()+"_"+operationContext.getName();
//                if (optional.isPresent())
//                    name = optional.get().key();  //model 名称

                ApiReturnJsonPro[] properties = (ApiReturnJsonPro[]) maps.get(requestMappingPatternName);
                if(properties == null){
                    return;
                }
                String name = operationContext.getName() + requestMappingPatternName.replaceAll("/","_");
                byte[] cs = SwaggerASMUtil.createRefModel(properties, name);
                Class hw = this.defineClass(name, cs, 0, cs.length);
                ResolvedType rt = typeResolver.resolve(hw);
                // 像documentContext的Models中添加我们新生成的Class
                operationContext.getDocumentationContext().getAdditionalModels().add(rt);
                //
                Set<ResponseMessage> set = new HashSet<ResponseMessage>();
                ModelRef mr = new ModelRef(name);
                set.add(new ResponseMessage(200,
                        "{\"ret\":\"0\",\"desc\":\"success\",\"data\":{}}",
                        mr,null,null));
                operationContext.operationBuilder().responseMessages(set);
//                operationContext.operationModelsBuilder().addReturn(rt).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }
}
