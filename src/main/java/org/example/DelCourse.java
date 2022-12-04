package org.example;

public class DelCourse {
    MyCourse myCourse;

    public String delCourse(Course course) {
        myCourse = new MyCourse();

        if (myCourse.user.getCourse().contains(course)) {
            myCourse.user.delCourse(course, course.GetCredit());
            myCourse.user.delSchedule(course.GetTime());
            return "Del Success!";
        }
        else {

//            System.out.println(myCourse.user.getCourse().get(0).ToCourseString());
//            System.out.println(course.ToCourseString());
            return "沒有課程!";
        }
    }
}
