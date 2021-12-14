import java.lang.annotation.Annotation;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize){
        super(corePoolSize, corePoolSize*2, 50L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable >());
    }

    @Override
    public void execute(Runnable command){
        int repeat = 1;
        Annotation[] annotations = command.getClass().getAnnotations();
        for(Annotation annotation : annotations){
            if (annotation instanceof Repeat)
                repeat = ((Repeat) annotation).value();
        }
        for (int i = 1; i<=repeat; i++)
            command.run();
    }
}
