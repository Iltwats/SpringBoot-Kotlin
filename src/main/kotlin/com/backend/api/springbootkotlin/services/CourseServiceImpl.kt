package com.backend.api.springbootkotlin.services

import com.backend.api.springbootkotlin.model.CourseList
import com.backend.api.springbootkotlin.model.Courses
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl : CourseService {
    override fun getCourse(): List<Courses> {
        return CourseList.courseList
    }

    override fun getCourseWithID(courseID: Int): Courses {
        return CourseList.courseList.first { course ->
            courseID == course.id
        }
    }

    override fun addCourse(courses: Courses): Courses {
        CourseList.courseList.add(courses)
        return CourseList.courseList.find {
            it == courses
        } ?: Courses(0, "", "")
    }

    override fun editCourse(courses: Courses): Courses {
        CourseList.courseList.forEach {
            if(it.id == courses.id){
                it.title = courses.title
                it.description = courses.description
            }
        }
        return CourseList.courseList.find {
            it == courses
        } ?: Courses(0, "", "")
    }

    override fun deleteCourse(courseID: Int): Boolean {
        return CourseList.courseList.removeIf {
            it.id == courseID
        }
    }
}