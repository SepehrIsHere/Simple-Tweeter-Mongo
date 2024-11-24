package org.practice.mongopractice.config;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.practice.mongopractice.dto.TweetDto;
import org.practice.mongopractice.dto.UserDto;
import org.practice.mongopractice.entities.Tweet;
import org.practice.mongopractice.entities.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ModelMapper modelMapper;

    public User convertToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

    public UserDto convertToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    public TweetDto convertToDto(Tweet tweet){
        return modelMapper.map(tweet, TweetDto.class);
    }

    public Tweet convertToEntity(TweetDto tweetDto){
        return modelMapper.map(tweetDto, Tweet.class);
    }

}
