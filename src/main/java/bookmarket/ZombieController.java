package bookmarket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZombieController {

    private boolean flag;

    public ZombieController(){
        flag = true;
    }

    @GetMapping({"/isHealthy"})
    public void zombie2() throws Exception {
        if (flag)
            return;
        else
            throw new Exception("zombie.....");
    }

    @GetMapping({"/makeZombie"})
    public void getStockInputs() {

        flag = false;

    }
}
