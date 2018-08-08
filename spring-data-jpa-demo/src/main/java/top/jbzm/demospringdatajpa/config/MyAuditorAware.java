package top.jbzm.demospringdatajpa.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author jbzm
 * @date 2018下午4:29
 **/
public class MyAuditorAware implements AuditorAware<Integer> {
    @Override
    public Optional<Integer> getCurrentAuditor() {
        return Optional.empty();
    }
}