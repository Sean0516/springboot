package com.voicecyber.config;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.integration.scheduling.PollerMetadata;

import java.io.IOException;

import static org.springframework.core.SpringProperties.getProperty;

/**
 * Created by Sean on 2018/8/8
 *
 * @author Sean
 */
@Configuration
public class IntegrationConfig {
    @Value("https://spring.io/blog.atom")
    private Resource resource;

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata pollerMetadata() {
        return Pollers.fixedDelay(5000).get();
    }

    /**
     * 构造入站通道适配器 作为数据输入
     *
     * @return
     * @throws IOException
     */
    @Bean
    public FeedEntryMessageSource feedEntryMessageSource() throws IOException {
        FeedEntryMessageSource messageSourceSpec = new FeedEntryMessageSource(resource.getURL(), "entry");
        return messageSourceSpec;
    }

    @Bean
    public IntegrationFlow integrationFlow() throws IOException {
        return IntegrationFlows.from(feedEntryMessageSource())
                .<SyndEntry, String>route(payload -> payload.getCategories().get(0).getName(),
                        mapping -> mapping.channelMapping("releases", "releasesChannel")
                ).get();
    }

    @Bean
    public IntegrationFlow releasesFlow() {
        return IntegrationFlows.from(MessageChannels.queue("releasesChannel", 10))
                .<SyndEntry, String>transform(e -> {
                    System.out.println(e.getTitle() + e.getAuthor() + getProperty("line.separator"));
                    return e.getTitle()  + e.getAuthor() + getProperty("line.separator");
                }).get();
    }

}
