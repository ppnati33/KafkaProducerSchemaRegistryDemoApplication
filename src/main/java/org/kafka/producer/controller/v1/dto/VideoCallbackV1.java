package org.kafka.producer.controller.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kafka.producer.controller.VideoCallback;

public class VideoCallbackV1 extends VideoCallback {

    @JsonProperty(required = true, value = "contact_info")
    public String contactInfo;

    @JsonProperty(required = true, value = "ehr_id")
    public String ehrId;

    @JsonProperty(required = true, value = "modality")
    public String modality;

    public VideoCallbackV1(String status, String contactInfo, String ehrId, String modality) {
        super(status);
        this.contactInfo = contactInfo;
        this.ehrId = ehrId;
        this.modality = modality;
    }

    @Override
    public String toString() {
        return "VideoCallback{" +
            "status='" + status + '\'' +
            ", contactInfo='" + contactInfo + '\'' +
            ", ehrId='" + ehrId + '\'' +
            ", modality='" + modality + '\'' +
            '}';
    }
}
