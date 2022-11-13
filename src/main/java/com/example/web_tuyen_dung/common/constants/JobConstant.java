package com.example.web_tuyen_dung.common.constants;

import com.example.web_tuyen_dung.model.JobStatus;

import java.util.Arrays;
import java.util.List;

public class JobConstant {
    public static List<JobStatus> JOB_STATUS_LIST = Arrays.asList(
        new JobStatus("WAIT", "Chờ phê duyệt"),
        new JobStatus("APPROVAL", "Đã phê duyệt"),
        new JobStatus("REFUSE", "Từ chối")
    );
}
