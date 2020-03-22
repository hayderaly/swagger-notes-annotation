//package com.example.swagger2_demo.config.swagger2.ret;
//
//import com.example.swagger2_demo.config.swagger2.Swagger2;
//import com.example.swagger2_demo.config.swagger2.params.ApiJsonProperty;
//import com.example.swagger2_demo.config.swagger2.params.SwaggerASMUtil;
//import com.example.swagger2_demo.config.swagger2.params.SwaggerMapContext;
//import com.example.swagger2_demo.config.swagger2.params.SwaggerRetMapContext;
//import com.fasterxml.classmate.ResolvedType;
//import com.fasterxml.classmate.TypeResolver;
//import com.google.common.base.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import springfox.documentation.service.ResolvedMethodParameter;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.OperationModelsProviderPlugin;
//import springfox.documentation.spi.service.contexts.OperationContext;
//import springfox.documentation.spi.service.contexts.RequestMappingContext;
//import springfox.documentation.swagger.common.SwaggerPluginSupport;
//
//import java.lang.reflect.Method;
//import java.util.Map;
//
///**
// * @author
// */
//@Configuration
//@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 2)  //plugin加载顺序，默认是最后加载
//public class MyOperationModelsProviderPlugin extends ClassLoader implements OperationModelsProviderPlugin {
//    @Autowired
//    private TypeResolver typeResolver;
//
////    @Override
//    public void apply(RequestMappingContext requestMappingContext) {
//        System.out.println("1111="+requestMappingContext.getReturnType().getTypeName());
//        if("void".equals(requestMappingContext.getReturnType().getTypeName())){
//            return;
//        }
//        if (requestMappingContext.getReturnType().isInstanceOf(Map.class) || true) {
//            // 根据参数上的ApiJsonObject注解中的参数动态生成Class
////            Optional<ApiReturnJson> optional = requestMappingContext.findAnnotation(ApiReturnJson.class);
////            ApiReturnJsonPro[] properties = null;
////            String name = null;
////            try {
////                //系统默认取该处的全局变量
////                Method method = Swagger2.class.getMethod("restApi");
////                ApiReturnJson apiReturnJson = method.getAnnotation(ApiReturnJson.class);
////                name = apiReturnJson.key()+"_"+requestMappingContext.getName();
////                ApiReturnJsonPro[] properties0 = apiReturnJson.value();
////                if (optional.isPresent()) {
////                    // model名称
////                    name = optional.get().key();
////                    ApiReturnJsonPro[] properties1 = optional.get().value();
////                    properties = new ApiReturnJsonPro[properties1.length+properties0.length];
////                    int k=0;
////                    for(;k<properties0.length;k++){properties[k] = properties0[k];}
////                    for(int p=0;p<properties1.length;p++){properties[k+p] = properties1[p];}
////                }
////                else{properties = properties0;}
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//
//
//            Map<String, Object> maps = SwaggerRetMapContext.getMap();
//            String requestMappingPatternName = requestMappingContext.getRequestMappingPattern();
////            ResolvedMethodParameter methodParameter = requestMappingContext.resolvedMethodParameter();
////            OperationContext operationContext = parameterContext.getOperationContext();
////            String requestMappingPatternName = operationContext.requestMappingPattern();
//
////            Optional<String> parameterNameOptional = methodParameter.defaultName();
////            String parameterName = parameterNameOptional.get();
//
//
////            String name = "H" + parameterName;
//            //name = SwaggerASMUtil.returnClassName(requestMappingPatternName,name);
//
//            requestMappingPatternName =  "/swagger/selectIndentNumberByPrimaryIdAndName";
//           String name = "String";
//System.out.println("requestMappingPatternName="+requestMappingPatternName);
//            ApiReturnJsonPro[] properties = (ApiReturnJsonPro[]) maps.get(requestMappingPatternName);
//            System.out.println("size="+properties.length);
//
//            byte[] cs = SwaggerASMUtil.createRefModel(properties, "String");
//            Class hw = this.defineClass(name, cs, 0, cs.length);
//            ResolvedType rt = typeResolver.resolve(hw);
//            // 像documentContext的Models中添加我们新生成的Class
//            requestMappingContext.getDocumentationContext().getAdditionalModels().add(rt);
//            requestMappingContext.operationModelsBuilder().addReturn(rt).build();
//        }
//    }
//
////    @Override
//    public boolean supports(DocumentationType documentationType) {
//        return true;
//    }
//}
