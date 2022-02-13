package org.kafka.producer.controller.v3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kafka.producer.controller.VideoCallback;

public class VideoCallbackV3 extends VideoCallback {

    @JsonProperty("contact_info")
    public String contactInfo;

    @JsonProperty("ehr_id")
    public Integer ehrId;

    @JsonProperty("modality")
    public String modality;

    public VideoCallbackV3(String status, String contactInfo, int ehrId, String modality) {
        super(status);
        this.contactInfo = contactInfo;
        this.ehrId = ehrId;
        this.modality = modality;
    }

    @Override
    public String toString() {
        return "VideoCallbackV3{" +
            "status='" + status + '\'' +
            ", contactInfo='" + contactInfo + '\'' +
            ", ehrId=" + ehrId +
            ", modality='" + modality + '\'' +
            '}';
    }
}
