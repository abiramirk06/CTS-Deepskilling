import React, { Component } from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

class App extends Component {
  constructor() {
    super();

    this.state = {
      showBooks: true,
      showBlogs: true,
      showCourses: true
    };
  }

  render() {
    return (
      <div style={{ textAlign: "center" }}>
        <h1>Blogger App</h1>

        {/* Method 1 - If using && operator */}
        {this.state.showBooks && <BookDetails />}

        <hr />

        {/* Method 2 - Ternary Operator */}
        {this.state.showBlogs ? <BlogDetails /> : <h3>No Blogs Available</h3>}

        <hr />

        {/* Method 3 - Element Variable */}
        {(() => {
          let component;

          if (this.state.showCourses) {
            component = <CourseDetails />;
          } else {
            component = <h3>No Courses Available</h3>;
          }

          return component;
        })()}
      </div>
    );
  }
}

export default App;