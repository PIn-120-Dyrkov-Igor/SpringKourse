package pin.coursework.recruiting;

public class RecruiterData {
    private static Long RecruiterId = null;
    private static boolean firstRegistrarion = true;

    private static boolean active = false;

    public static boolean isSelected(){
        if(RecruiterId != null)
            return true;
        else return false;
    }

    public static void clearRecruiter(){
        RecruiterId = null;
    }

    public static void setRecruiter(Long id){
        RecruiterId = id;
        firstRegistrarion = false;
    }

    public static long getRecruiter(){
        return RecruiterId;
    }

    public static boolean isFirstRegistrarion(){
        return firstRegistrarion;
    }

    public static boolean getActive(){
        return active;
    }

    public static void setActive(Boolean a){
        active = a;
    }

}
