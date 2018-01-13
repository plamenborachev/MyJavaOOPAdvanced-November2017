package contracts;

public interface Database {

    CrudRepository<Boat> getBoatRepository();

    CrudRepository<BoatEngine> getBoatEngineRepository();
}
