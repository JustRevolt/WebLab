 class Factory {

    private static PointDao pointDao = null;
    private static Factory instance = null;

     static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

     PointDao getPointDao(){
        if (pointDao == null){
            pointDao = new PointDaoImp();
        }
        return pointDao;
    }
}