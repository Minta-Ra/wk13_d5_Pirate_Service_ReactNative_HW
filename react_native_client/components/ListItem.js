import React from 'react';
import { Text } from 'react-native';


export default function ListItem ({pirate}) {
    
    return (
        <Text>
            {pirate.firstName}
            {" "}
            {pirate.lastName}
            {" "}
            Age:
            {pirate.age}
            {" "}
            Ship:
            {" "}
            {pirate.ship.name}
        </Text>
    );

};