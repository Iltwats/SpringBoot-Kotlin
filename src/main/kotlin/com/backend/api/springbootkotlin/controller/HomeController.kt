package com.backend.api.springbootkotlin.controller

import com.backend.api.springbootkotlin.model.Courses
import com.backend.api.springbootkotlin.services.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class HomeController(@Autowired val courseService: CourseService) {

    @GetMapping("/courses")
    fun getCourses(): List<Courses> {
        return courseService.getCourse()
    }

    @GetMapping("/courses/{courseId}")
    fun getCourseID(@PathVariable courseId: Int): Courses {
        return courseService.getCourseWithID(courseId)
    }

    @PostMapping("/courses")
    fun addCourse(@RequestBody courses: Courses): Courses {
        return courseService.addCourse(courses)
    }
}