package ru.bobans.map_obj;

public class FileNameObj {
    String FileName;
    String idSender;
    String DateOfRequest;
    String TypeOfReqest;
    String NumOfRequest;


    public FileNameObj(String fileName) {
            this.FileName=fileName;
            if (fileName.length()==32) {
                this.idSender=fileName.substring(0,14);
                this.DateOfRequest=fileName.substring(15,21);
                this.TypeOfReqest=fileName.substring(22,23);
                this.NumOfRequest=fileName.substring(24,28);
            } else throw new  IllegalArgumentException("Ошибка разбора имени файла. Negative sizes of string:"+ fileName.length() );



    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getIdSender() {
        return idSender;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    public String getDateOfRequest() {
        return DateOfRequest;
    }

    public void setDateOfRequest(String dateOfRequest) {
        DateOfRequest = dateOfRequest;
    }

    public String getTypeOfReqest() {
        return TypeOfReqest;
    }

    public void setTypeOfReqest(String typeOfReqest) {
        TypeOfReqest = typeOfReqest;
    }

    public String getNumOfRequest() {
        return NumOfRequest;
    }

    public void setNumOfRequest(String numOfRequest) {
        NumOfRequest = numOfRequest;
    }


    @Override
    public String toString() {
        return "FileNameObj{" +
                "FileName='" + FileName + '\'' +
                ", idSender='" + idSender + '\'' +
                ", DateOfRequest='" + DateOfRequest + '\'' +
                ", TypeOfReqest='" + TypeOfReqest + '\'' +
                ", NumOfRequest='" + NumOfRequest + '\'' +
                '}';
    }
}
