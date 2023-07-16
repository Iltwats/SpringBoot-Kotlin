package com.backend.api.springbootkotlin.controller

import com.backend.api.springbootkotlin.model.Courses
import com.backend.api.springbootkotlin.services.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    @PutMapping("/courses")
    fun editCourse(@RequestBody courses: Courses): Courses{
        return courseService.editCourse(courses)
    }

    @DeleteMapping("/courses/{courseID}")
    fun deleteCourse(@PathVariable courseID: Int): ResponseEntity<HttpStatus>{
        val result = courseService.deleteCourse(courseID)
        return if(result){
            ResponseEntity(HttpStatus.OK)
        }else{
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}