package game.client.controllers;

import game.client.grpc.DataServiceGrpc;
import game.client.grpc.ServerService;
import game.client.random.Random;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class IndexController {
    private final ManagedChannel channel;
    private final Random random;

    @Autowired
    public IndexController(ManagedChannel channel, Random random) {
        this.channel = channel;
        this.random = random;
    }

    /**
     * Для примера.
     * Вернуть должен объект в виде стринга.
     *
     * @return
     */
    // TODO дописать (В рандоме заглушка!)
    @GetMapping("/index")
    public String index() {
        DataServiceGrpc.DataServiceBlockingStub stub = DataServiceGrpc.newBlockingStub(channel);
        ServerService.DataRequest request = ServerService.DataRequest.newBuilder()
                .setId(random.getRandomId(1, 1)).build();
        ServerService.DataResponse response = stub.swap(request);
        return response.getObject();
    }
}
