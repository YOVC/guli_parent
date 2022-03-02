package cn.jr.ExceptionHandler;

import cn.jr.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody       //为了能够返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message(e.getMessage()+":执行了全局异常处理");
    }

    //特殊异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message(e.getMessage()+":执行了特殊异常处理");
    }


    //自定义异常处理
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
