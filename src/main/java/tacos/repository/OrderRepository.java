package tacos.repository;

import tacos.entity.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
