package my.examples.demo.controller

import my.examples.demo.dto.Board
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession


@Controller
@RequestMapping("/boards")
class BoardController {
    @GetMapping
    fun list(session: HttpSession, modelMap: ModelMap): String {
        val board2 = Board(name = "kim", content = "content2", title = "title2")
        val list = arrayListOf(
                Board(name = "kim", content = "content1", title = "title1"),
                board2,
                Board(name = "kim", content = "content3", title = "title3")
        )

        session.setAttribute("sessionValue", "hello session")
        with(modelMap) {
            addAttribute("test", "test data\ntest data1\ntest data1\ntest data1\ntest data1\ntest data1\ntest data1\n")
            addAttribute("count", 100)
            addAttribute("list", list)
        }
        return "list"
    }

    @GetMapping("/{id}")
    fun view(@PathVariable id: Long): String {
        println("id : $id")
        return "view"
    }

    @GetMapping("/write")
    fun write(): String = "redirect:/boards"
}
