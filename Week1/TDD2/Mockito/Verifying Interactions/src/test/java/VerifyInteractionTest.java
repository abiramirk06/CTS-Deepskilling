import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class VerifyInteractionTest {

    @Test
    void testVerifyInteraction() {

        // Create Mock Object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Create Service
        MyService service = new MyService(mockApi);

        // Call the method
        service.fetchData();

        // Verify interactions
        verify(mockApi).getData();

        verify(mockApi, times(1)).getData();

        verify(mockApi, atLeastOnce()).getData();

        verify(mockApi, atMost(1)).getData();

        verify(mockApi, never()).saveData();
    }
}