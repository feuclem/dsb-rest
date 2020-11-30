package com.dsb.rest

import com.dsb.rest.dao.EquipementsDAO
import com.dsb.rest.dao.PanopliesDAO
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
open class DsbApplication {

    @Bean
    open fun equipementsDAOInitializer() = EquipementsDAO()

    @Bean
    open fun panopliesDAOInitializer() = PanopliesDAO()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(DsbApplication::class.java, *args)
        }
    }

    @Bean
    open fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/amulettes/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/anneaux/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/armes/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/bottes/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/boucliers/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/capes/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/ceintures/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/coiffes/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/dofus/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/familiers/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/montures/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/panopliebonus/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
                registry.addMapping("/trophees/*")
                    .allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com")
            }
        }
    }
}