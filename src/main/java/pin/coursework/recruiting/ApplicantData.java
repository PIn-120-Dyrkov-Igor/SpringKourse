package pin.coursework.recruiting;

public class ApplicantData {

    private static Long ApplicantId = null;
    private static boolean firstRegistrarion = true;

    private static Long ResumeId = null;

    private static boolean active = false;

    public static boolean isSelected(){
        if(ApplicantId != null)
            return true;
        else return false;
    }

    public static void clearApplicant(){
        ApplicantId = null;
    }

    public static void setApplicant(Long id){
        ApplicantId = id;
        firstRegistrarion = false;
    }

    public static long getApplicant(){
        return ApplicantId;
    }

    public static boolean isFirstRegistrarion(){
        return firstRegistrarion;
    }

    public static void setResume(Long id){
        ResumeId = id;
    }

    public static long getResume(){
        return ResumeId;
    }

    public static boolean getActive(){
        return active;
    }

    public static void setActive(Boolean a){
        active = a;
    }

}
