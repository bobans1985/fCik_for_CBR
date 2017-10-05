package ru.bobans.map_obj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "acknowledgementType",
        "resultCode",
        "resultText",
        "to",
        "from",
        "messageID",
        "correlationMessageID",
        "messageType",
        "priority",
        "createTime"
})
@XmlRootElement(name = "File")
public class FileKvit {

    @XmlElement(name = "AcknowledgementType", required = true)
    protected String acknowledgementType;
    @XmlElement(name = "ResultCode", required = true)
    protected String resultCode;
    @XmlElement(name = "ResultText", required = true)
    protected String resultText;
    @XmlElement(name = "To", required = true)
    protected String to;
    @XmlElement(name = "From", required = true)
    protected String from;
    @XmlElement(name = "MessageID", required = true)
    protected String messageID;
    @XmlElement(name = "CorrelationMessageID", required = true)
    protected String correlationMessageID;
    @XmlElement(name = "MessageType", required = true)
    protected String messageType;
    @XmlElement(name = "Priority", required = true)
    protected String priority;
    @XmlElement(name = "CreateTime", required = true)
    protected String createTime;

    public String getAcknowledgementType() {
        return acknowledgementType;
    }

    public void setAcknowledgementType(String value) {
        this.acknowledgementType = value;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String value) {
        this.resultCode = value;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String value) {
        this.resultText = value;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String value) {
        this.to = value;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String value) {
        this.from = value;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String value) {
        this.messageID = value;
    }


    public String getCorrelationMessageID() {
        return correlationMessageID;
    }


    public void setCorrelationMessageID(String value) {
        this.correlationMessageID = value;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String value) {
        this.messageType = value;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String value) {
        this.priority = value;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String value) {
        this.createTime = value;
    }

}

