package cn.gl.librarymanagementsystem.result;

public class ResultGenerate {

    public static <E> Result<E> generateResult(Status status, String description, E data){
        Result<E> result = new Result<>();
        if (status.equals(Status.fail)) {
            result.setStatus(Status.fail);
        }else {
            result.setStatus(Status.success);
        }
        result.setDescription(description);
        result.setData(data);
        return result;
    }
}
