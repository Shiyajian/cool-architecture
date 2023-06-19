package ${package};
import github.shiyajian.${rootArtifactId}.application.service.CaseTemplate;
import github.shiyajian.${rootArtifactId}.application.service.hello.context.HelloCreateContext;
import github.shiyajian.${rootArtifactId}.application.service.hello.settings.HelloSettings;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-04-03
 */
@Component
public class HelloCreateCase extends CaseTemplate<HelloCreateContext, HelloSettings> {

    public static final String LOCK_KEY_PREFIX = "shiyajian.hello.%s";

//    @Autowired
//    private HelloRepository helloRepository;

//    @Autowired
//    private HelloDomainService helloDomainService;

    @Override
    protected Configs<HelloCreateContext> configs() {
        return Configs.<HelloCreateContext>builder()
//                .lockKeyProcessor((context -> String.format(LOCK_KEY_PREFIX, context.getHello())))
                .logMessageProcessor((context) -> "创建了hello")
                .build();
    }

    @Override
    protected void prepare(HelloCreateContext context) {

    }

    @Override
    protected void post(HelloCreateContext context) {

    }

    @Override
    protected void after(HelloCreateContext context) {

    }
}
